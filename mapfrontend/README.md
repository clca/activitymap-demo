# Commit Map for Project Java (UI)

## Get, Build and Run the Code

```bash
git clone git@gitlab-odx.oracle.com:irfan.ahmed/java-commit-map.git
yarn install
yarn build 

# If you already have code checked out then make sure you delete the build directory before rebuilding
```

This will create a `build` folder that can be used to serve the UI. You can also serve the UI at the default port of 
`5000` by calling the following command.

```bash
yarn serve
open http://localhost:5000
```

## Clean up and reinstallation
```bash
git pull
rm -rf node_modules
rm -rf build
yarn install
yarn build
```

## Backend Stats Service
The UI is using a node server to serve the UI and get the stats from the backend. The UI connects to `/stats` on the UI's node server to get the stats. The UI's node server then makes a call to the backend service to get the stats from the service running in the cluster.
 
Currently, the UI has been configured to connect to a service running as `http://githubstats:9000/githubstats/stats`.
This can be changed by opening the file [mapRoutes.js](https://gitlab-odx.oracle.com/irfan
.ahmed/java-commit-map/blob/master/router/mapRoutes.js#L9) and setting the value for `service`. 

### Project Bootstrap Information
This project was bootstrapped with [Create React App](https://github.com/facebookincubator/create-react-app).
You can find complete information about the folder and dev environment setup and usage [here](CreateReactAppREADME.md)

### LICENSE

[MIT](./LICENSE)



