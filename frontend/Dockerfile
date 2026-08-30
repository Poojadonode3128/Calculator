FROM node:24 AS build

WORKDIR /app

COPY frontend/package.json frontend/package-lock.json ./

RUN npm config set strict-ssl false
RUN npm ci --no-audit --no-fund

COPY frontend/ ./

RUN npm run build

FROM nginx:alpine

COPY --from=build /app/dist /usr/share/nginx/html

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]