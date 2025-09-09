import { Preset } from '@primeuix/themes/types';

import Material from '@primeuix/themes/material';
import { palette } from '@primeuix/themes';

export const Classic: Preset = {
	...Material,
	semantic: {
		...Material.semantic,
		primary: palette('#4a1a4a'),
		secondary: palette('#c8a456'),
		tertiary: palette('#2d1b3d'),
	},
};
