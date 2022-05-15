# Spring on GCP AppEngine with IAP

This is a simple spring boot application which can be used to try App Engine with IAP (Identity Aware Proxy).

## Install

### Infrastructre

Create on Google Cloud Platform:

- Cloud identity
- Project
- App Engine
- IAP

### Backend

- configure gcloud CLI

```bash
gcloud auth login
gcloud config set project <PORJECT_ID>
```

- Define App settings in ``src/main/appengine/app.yaml``

```
runtime: java11

env_variables:
  PROJECT_NUMBER: <YOUR_NUMBER>
  PROJECT_ID: <YOUR_ID>
```

- Deploy

```bash
./gradlew appengineDeploy
```

## Usage

- Go to the Identity-Aware Proxy page

- Assign `IAP-secured Web App User` role to you.

- Open your web site in a brower

- Select your Google Account

- The home page return the content of IAP HTTP headers:

  - X-Goog-Authenticated-User-Email
  - X-Goog-Authenticated-User-Id
  - x-goog-iap-jwt-assertion
