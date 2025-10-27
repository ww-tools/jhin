"use client";

import Image from "next/image";
import Link from "next/link";
import { useEffect, useMemo, useState, useCallback } from "react";
import { useParams } from "next/navigation";
import { API_BASE } from "@/lib/config";

// Types
type ChampionEntry = { key: string; id: string; name: string };
type MatchupsResponse = Record<string, number[]>; // opponentChampionId -> itemIds

type LoadingChampionImageProps = {
  champId: string; // canonical id, e.g. "Aatrox"
  alt: string;
  className?: string;
};

function LoadingChampionImage({ champId, alt, className }: LoadingChampionImageProps) {
  // Try a small sequence of plausible loading splash indices; hide if none found

  const src = `/champion/loading/${champId}_0.jpg`;

  return (
    <Image
      src={src}
      alt={alt}
	  height={560}
	  width={308}
      className={`object-contain ${className ?? ""}`}
    />
  );
}

export default function ChampionMatchupsPage() {
  const params = useParams();
  const championIdParam = (params?.championId as string) ?? ""; // numeric string ideally

  const [champByKey, setChampByKey] = useState<Map<number, { id: string; name: string }>>(new Map());
  const [itemsById, setItemsById] = useState<Map<number, { name: string }>>(new Map());
  const [matchups, setMatchups] = useState<MatchupsResponse | null>(null);
  const [selectedOpponent, setSelectedOpponent] = useState<number | null>(null);
  const [query, setQuery] = useState("");
  const [showSuggestions, setShowSuggestions] = useState(false);
  const [showAllOverride, setShowAllOverride] = useState(false);
  const [allChamps, setAllChamps] = useState<{ key: number; id: string; name: string }[]>([]);

  // Load champions map
  useEffect(() => {
    let cancelled = false;
    const load = async () => {
      try {
        const res = await fetch("/champion.json");
        const json = await res.json();
        let list: ChampionEntry[] = [];
        if (json && json.data && typeof json.data === "object") {
          list = Object.values(json.data) as ChampionEntry[];
        } else if (Array.isArray(json)) {
          list = json as ChampionEntry[];
        }
        const map = new Map<number, { id: string; name: string }>();
        for (const c of list) {
          const keyNum = Number(c.key ?? c.id);
          if (!Number.isNaN(keyNum)) {
            map.set(keyNum, { id: c.id, name: c.name });
          }
        }
        const arr = Array.from(map.entries()).map(([key, v]) => ({ key, id: v.id, name: v.name }))
          .sort((a, b) => a.name.localeCompare(b.name));
        if (!cancelled) {
          setChampByKey(map);
          setAllChamps(arr);
        }
      } catch (e) {
        console.error("Failed to load champion.json", e);
      }
    };
    load();
    return () => {
      cancelled = true;
    };
  }, []);

  // Load items map
  useEffect(() => {
    let cancelled = false;
    const load = async () => {
      try {
        const res = await fetch("/item.json");
        const json = await res.json();
        const map = new Map<number, { name: string }>();
        if (json && json.data && typeof json.data === "object") {
          for (const [id, item] of Object.entries<any>(json.data)) {
            const idNum = Number(id);
            if (!Number.isNaN(idNum)) {
              map.set(idNum, { name: (item as any).name ?? String(id) });
            }
          }
        } else if (Array.isArray(json)) {
          for (const anyItem of json as any[]) {
            const idNum = Number((anyItem as any).id);
            if (!Number.isNaN(idNum)) {
              map.set(idNum, { name: (anyItem as any).name ?? String(idNum) });
            }
          }
        }
        if (!cancelled) setItemsById(map);
      } catch (e) {
        console.error("Failed to load item.json", e);
      }
    };
    load();
    return () => {
      cancelled = true;
    };
  }, []);

  // Load matchups
  useEffect(() => {
    let cancelled = false;
    const idNum = Number(championIdParam);
    if (Number.isNaN(idNum)) return;
    const load = async () => {
      try {
        const res = await fetch(`${API_BASE}/api/v1/matchups/${idNum}`);
        if (!res.ok) {
          setMatchups({});
          return;
        }
        const data: MatchupsResponse = await res.json();
        if (!cancelled) {
          setMatchups(data);
          const keys = Object.keys(data);
          if (keys.length) setSelectedOpponent(Number(keys[0]));
        }
      } catch (e) {
        console.error("Failed to load matchups", e);
      }
    };
    load();
    return () => {
      cancelled = true;
    };
  }, [championIdParam]);

  const mainChamp = useMemo(() => {
    const idNum = Number(championIdParam);
    return champByKey.get(idNum);
  }, [champByKey, championIdParam]);

  const opponents = useMemo(() => {
    if (!matchups) return [] as number[];
    return Object.keys(matchups)
      .map(k => Number(k))
      .filter(k => !Number.isNaN(k));
  }, [matchups]);

  const opponentEntries = useMemo(() => {
    return opponents
      .map((opId) => ({ id: opId, champ: champByKey.get(opId) }))
      .filter(e => !!e.champ) as { id: number; champ: { id: string; name: string } }[];
  }, [opponents, champByKey]);

  const filteredSuggestions = useMemo(() => {
    const base = allChamps;
    if (showAllOverride) return base; // show all when dropdown button clicked
    const q = query.trim().toLowerCase();
    if (!q) return base.slice(0, 20);
    return base.filter(e =>
      e.name.toLowerCase().includes(q) || e.id.toLowerCase().includes(q)
    ).slice(0, 50);
  }, [allChamps, query, showAllOverride]);

  const onPickOpponent = useCallback((opId: number) => {
    setSelectedOpponent(opId);
    const champ = champByKey.get(opId);
    if (champ) setQuery(champ.name);
    setShowSuggestions(false);
  }, [champByKey]);

  const selectedOpponentChamp = useMemo(() => {
    return selectedOpponent != null ? champByKey.get(selectedOpponent) : undefined;
  }, [selectedOpponent, champByKey]);

  return (
    <div className="min-h-screen p-6 sm:p-10">
      <div className="mb-6 flex items-center justify-between gap-3">
        <div className="flex items-center gap-3">
          <Link href="/" className="text-blue-500 hover:underline">← Back</Link>
          <h1 className="text-2xl font-semibold">{mainChamp ? mainChamp.name : `Champion ${championIdParam}`}</h1>
        </div>
        {/* Opponent search */}
        <div className="relative w-full max-w-md">
          <input
            type="text"
            value={query}
            onChange={(e) => { setQuery(e.target.value); setShowSuggestions(true); setShowAllOverride(false); }}
            onFocus={() => setShowSuggestions(true)}
            placeholder="Search opponent champion..."
            className="w-full border rounded-md pr-9 px-3 py-2 bg-white/80 text-black placeholder:text-gray-500 focus:outline-none focus:ring-2 focus:ring-blue-500"
          />
          <button type="button" aria-label="Open champion list" className="absolute right-2 top-1/2 -translate-y-1/2 text-gray-700 hover:text-black" onClick={() => { setShowSuggestions(v => !v); setShowAllOverride(true); }}>
            ▼
          </button>
          {showSuggestions && filteredSuggestions.length > 0 && (
            <div className="absolute z-10 mt-1 w-full max-h-64 overflow-auto rounded-md border bg-white text-black shadow">
              {filteredSuggestions.map(s => (
                <button
                  key={s.key}
                  type="button"
                  className="w-full text-left px-3 py-2 hover:bg-gray-100 flex items-center gap-2"
                  onClick={() => onPickOpponent(s.key)}
                >
                  <Image
                    src={`/champion/tiles/${s.id}_0.jpg`}
                    alt={s.name}
                    width={40}
                    height={40}
                    className="rounded object-cover"
                  />
                  <span>{s.name}</span>
                </button>
              ))}
            </div>
          )}
        </div>
      </div>

      {/* Triple panel: selected champion (left) — items (center) — opponent (right) */}
      <div className="grid grid-cols-1 md:grid-cols-[1fr_1.2fr_1fr] items-start gap-6">
        {/* Left: Selected champion */}
        <div className="rounded-lg overflow-hidden border">
          <div className="bg-black/20 flex items-center justify-center">
            {mainChamp && (
              <LoadingChampionImage champId={mainChamp.id} alt={mainChamp.name} />
            )}
          </div>
          {mainChamp && (
            <div className="p-3">
              <div className="font-medium">{mainChamp.name}</div>
              <div className="text-xs text-gray-500">ID: {championIdParam}</div>
            </div>
          )}
        </div>

        {/* Center: Items */}
        <div className="rounded-lg border p-4 flex flex-col items-center justify-center md:min-h-[560px]">
          <h2 className="font-semibold mb-3 text-center">Recommended Items</h2>
          {selectedOpponent != null && matchups && matchups[String(selectedOpponent)] ? (
            <div className="flex flex-col flex-wrap items-center justify-center gap-4">
              {matchups[String(selectedOpponent)].map((itemId, idx) => {
                const item = itemsById.get(itemId);
                const src = `/item/${itemId}.png`;
                return (
                  <div key={`${itemId}-${idx}`} className="flex w-full items-center gap-3 p-2 border rounded bg-white/5">
                    <div className="relative w-12 h-12">
                      <Image src={src} alt={item ? item.name : String(itemId)} fill className="object-cover rounded" />
                    </div>
                    <div>
                      <div className="text-sm font-medium">{item ? item.name : `Item ${itemId}`}</div>
                      <div className="text-xs text-gray-500">ID: {itemId}</div>
                    </div>
                  </div>
                );
              })}
            </div>
          ) : (
            <div className="text-sm text-gray-500">Select an opponent to view item recommendations.</div>
          )}
        </div>

        {/* Right: Opponent champion */}
        <div className="rounded-lg overflow-hidden border">
          <div className="bg-black/20 flex items-center justify-center">
            {selectedOpponentChamp && (
              <LoadingChampionImage champId={selectedOpponentChamp.id} alt={selectedOpponentChamp.name} />
            )}
          </div>
          {selectedOpponentChamp && (
            <div className="p-3">
              <div className="font-medium">{selectedOpponentChamp.name}</div>
              <div className="text-xs text-gray-500">ID: {selectedOpponent}</div>
            </div>
          )}
        </div>
      </div>

      {/* Helper: If there are no matchup predictions */}
      {opponents.length === 0 && (
        <div className="mt-6 text-sm text-gray-500">No matchup predictions found for this champion.</div>
      )}
    </div>
  );
}
