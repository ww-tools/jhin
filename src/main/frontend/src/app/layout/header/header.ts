import { ChangeDetectionStrategy, Component } from '@angular/core';

@Component({
	selector: 'jhin-header',
	imports: [],
	templateUrl: './header.html',
	styleUrl: './header.css',
	changeDetection: ChangeDetectionStrategy.OnPush,
})
export class Header {}
