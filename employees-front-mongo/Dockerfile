FROM tiangolo/node-frontend:10 as node
WORKDIR /app
COPY package*.json /app/
RUN npm install
COPY ./ /app/
ARG configuration=production
RUN npm run build -- --output-path=./dist/employee-management --configuration $configuration
RUN sed -i "s/BUILD_VERSION_VAR/\"BUILD_NUMBER\"/g"  /app/dist/employee-management/index.html
RUN sed -i "s/BUILD_DATE_VAR/\"$(date)\"/g"  /app/dist/employee-management/index.html

FROM nginx:1.17.1-alpine
COPY nginx.conf /etc/nginx/nginx.conf
COPY --from=node /app/dist/employee-management/ /usr/share/nginx/html
