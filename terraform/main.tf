locals {
  project_short_name  = var.project_short_name
  project_long_name   = var.project_long_name
  organization_id     = var.organization_id
  billing_account_id  = var.billing_account_id
  email_address       = var.email_address
}

module "gcp_project" {
  source             = "git::https://github.com/0xdbe-terraform/terraform-gcp-project.git?ref=v1.1.0"
  organization_id    = local.organization_id
  billing_account_id = local.billing_account_id
  project_short_name = local.project_short_name
  project_long_name  = local.project_long_name
}

module "gcp_iap" {
  source             = "git::https://github.com/0xdbe-terraform/terraform-gcp-iap.git?ref=v1.1.0"
  email_address      = local.email_address
  project_id         = module.gcp_project.project_id
  project_long_name  = local.project_long_name
}

module "gcp_app_engine" {
  source               = "git::https://github.com/0xdbe-terraform/terraform-gcp-app-engine.git?ref=v1.0.0"
  project_id           = module.gcp_project.project_id
  oauth2_client_id     = module.gcp_iap.iap_client_id
  oauth2_client_secret = module.gcp_iap.iap_client_secret
}