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

```bash
export GOOGLE_CLOUD_PROJECT=<PROJECT_ID>
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
