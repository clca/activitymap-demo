FROM node:alpine
WORKDIR /app/console

COPY . .
RUN rm -rf build
RUN yarn install --pure-lockfile
run yarn add file:./githubstats-api-v2
RUN yarn build

ENV NODE_ENV=production

EXPOSE 3000
CMD ["yarn", "serve"]
