import { Routes } from '@angular/router';

export const routes: Routes = [
	{
		path: '',
		loadComponent: () =>
			import('./layout/main-view/main-view').then((m) => m.MainView),
	},
];
