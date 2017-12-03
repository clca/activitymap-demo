FROM node:alpine
WORKDIR /app/console

COPY . .
RUN rm -rf build
RUN yarn install --pure-lockfile
RUN yarn build

ENV NODE_ENV=production

EXPOSE 3000
CMD ["yarn", "serve"]
