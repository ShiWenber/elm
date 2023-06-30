// module.exports = {
//   content: [],
//   theme: {
//     extend: {},
//   },
//   plugins: [],
// }
// module.exports = {
//   content: ["./src/**/*.{html,js,css}"],
//   theme: {
//     extend: {},
//   },
//   plugins: [],
// }
module.exports = {
  purge: {
    content: [
      './src/**/*.html',
      './src/**/*.vue',
      './src/**/*.jsx',
    ],
    options: {
      safelist: [],
    },
  },
  theme: {
    extend: {},
  },
  variants: {},
  plugins: [],
  corePlugins: {},
  future: {},
  experimental: {},
  prefix: '',
  important: false,
  separator: ':',
  purgeLayersByDefault: true,
  preserveHtmlElements: false,
  mode: 'jit',
  darkMode: false,
  themeVariants: [],
  plugins: [
    require('@tailwindcss/forms'),
  ],
  output: {
    dir: './assets/css',
  },
};