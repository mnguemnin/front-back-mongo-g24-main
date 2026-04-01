# Stage 1: Build Node frontend
FROM tiangolo/node-frontend:10 AS node

WORKDIR /app

# Copy package.json and install dependencies
COPY package*.json /app/
RUN npm install

# Copy app source
COPY ./ /app/

# Build the app
ARG CONFIGURATION=production
RUN npm run build -- --output-path=./dist/employee-management --configuration $CONFIGURATION

# Replace build version and date placeholders
RUN sed -i "s/BUILD_VERSION_VAR/\"BUILD_NUMBER\"/g" /app/dist/employee-management/index.html && \
    sed -i "s/BUILD_DATE_VAR/\"$(date)\"/g" /app/dist/employee-management/index.html

# Stage 2: Serve with Nginx
FROM nginx:1.17.1-alpine

# Copy custom Nginx config
COPY nginx.conf /etc/nginx/nginx.conf

# Create directory with correct permissions for OpenShift
RUN mkdir -p /usr/share/nginx/html && \
    chown -R 1001:0 /usr/share/nginx/html && \
    chmod -R 755 /usr/share/nginx/html

# Copy built frontend from previous stage
COPY --from=node /app/dist/employee-management/ /usr/share/nginx/html

# Use non-root user (OpenShift default)
USER 1001

# Expose default Nginx port
EXPOSE 8080

# Start Nginx
CMD ["nginx", "-g", "daemon off;"]
