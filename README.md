# Spring on GCP AppEngine with IAP

This is a simple spring boot application which can be used to try App Engine with IAP (Identity Aware Proxy).

## Install

### Infrastructre

- Get GCP credential

```bash
gcloud auth application-default login
```

- Set variable for terraform in ``terraform/terraform.tfvars``:

```
project_short_name  = "hw"
project_long_name   = "Hello World"
organization_id     = "xxxx"
billing_account_id  = "xxxx"
email_address       = "contact@example.com"
```

- Deploy infra

```bash
cd terraform
terraform apply
```

### Application

- Get GCP credential

```bash
gcloud auth login
```

- Configure gcloud CLI

```bash
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

- Assign role called `IAP-secured Web App User` (ID: ``roles/iap.httpsResourceAccessor``) to you.

- Open your web site in a brower

- Select your Google Account

- The home page return the content of IAP HTTP headers:

  - X-Goog-Authenticated-User-Email
  - X-Goog-Authenticated-User-Id
  - x-goog-iap-jwt-assertion
