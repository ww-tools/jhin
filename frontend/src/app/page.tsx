'use client'

import Image from 'next/image';
import Link from 'next/link';
import { useEffect, useMemo, useState } from 'react';

// Types for champion data, compatible with typical DDragon champion.json
type ChampionDataEntry = {
  key: string; // numeric string, e.g. "266"
  id: string; // canonical id, e.g. "Aatrox"
  name: string; // display name
};

export default function Home() {
  const [champions, setChampions] = useState<ChampionDataEntry[]>([]);
  const [query, setQuery] = useState('');

  useEffect(() => {
    let cancelled = false;
    const load = async () => {
      try {
        const res = await fetch('/champion.json');
        const json = await res.json();
        let list: ChampionDataEntry[] = [];
        // Try DDragon format { data: { Aatrox: {...}, ... } }
        if (json && json.data && typeof json.data === 'object') {
          list = Object.values(json.data) as ChampionDataEntry[];
        } else if (Array.isArray(json)) {
          // Fallback: already an array
          list = json as ChampionDataEntry[];
        }
        // Deduplicate and sort by name
        const seen = new Set<string>();
        const unique = list.filter(c => {
          const k = c.key ?? c.id;
          if (!k || seen.has(k)) return false;
          seen.add(k);
          return true;
        });
        unique.sort((a, b) => a.name.localeCompare(b.name));
        if (!cancelled) setChampions(unique);
      } catch (e) {
        console.error('Failed to load champion.json', e);
      }
    };
    load();
    return () => {
      cancelled = true;
    };
  }, []);

  const filtered = useMemo(() => {
    const q = query.trim().toLowerCase();
    if (!q) return champions;
    return champions.filter(c =>
      c.name.toLowerCase().includes(q) || c.id.toLowerCase().includes(q)
    );
  }, [champions, query]);

  return (
    <div className="min-h-screen p-6 sm:p-10">
      <h1 className="text-2xl font-semibold mb-4">Search a Champion</h1>
      <input
        type="text"
        placeholder="Type a champion name..."
        value={query}
        onChange={e => setQuery(e.target.value)}
        className="w-full max-w-xl border rounded-md px-3 py-2 mb-6 bg-white/80 text-black placeholder:text-gray-500 focus:outline-none focus:ring-2 focus:ring-blue-500"
      />

      <div className="grid gap-4 grid-cols-[repeat(auto-fill,minmax(180px,1fr))]">
        {filtered.map(champ => {
          const splash = `/champion/splash/${champ.id}_0.jpg`;
          const numericId = champ.key ?? champ.id; // prefer key for routing
          return (
            <Link key={numericId} href={`/champion/${numericId}`} className="group block rounded-lg overflow-hidden border bg-white/5 hover:shadow">
              <div className="aspect-[5/3] relative bg-black/20">
                {/* Use next/image for optimization; falls back if missing */}
                <Image src={splash} alt={champ.name} fill sizes="(max-width: 768px) 100vw, 33vw" className="object-cover" onError={(e) => {
                  const img = e.currentTarget as HTMLImageElement;
                  img.style.display = 'none';
                }} />
              </div>
              <div className="p-3">
                <div className="font-medium">{champ.name}</div>
                <div className="text-xs text-gray-500">ID: {numericId}</div>
              </div>
            </Link>
          );
        })}
      </div>
    </div>
  );
}
