// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `.angular-cli.json`.

export const environment = {
  production: false,
  api: "http://localhost:8080",
  lat: 4.6567173,
  long: -74.0572354,
  zoom: 14,
  apiGoolge: "https://maps.googleapis.com/maps/api/geocode/json",
  googleKey: "AIzaSyDJ_l02eBc3mby0IwBry9r0CU5nPuonSow"
};
