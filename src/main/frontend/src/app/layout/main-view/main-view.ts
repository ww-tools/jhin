import { ChangeDetectionStrategy, Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Header } from '../header/header';
import { Footer } from '../footer/footer';

@Component({
	selector: 'jhin-main-view',
	imports: [RouterOutlet, Header, Footer],
	templateUrl: './main-view.html',
	styleUrl: './main-view.css',
	changeDetection: ChangeDetectionStrategy.OnPush,
})
export class MainView {}
