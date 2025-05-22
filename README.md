# zendesk-demo
Built a demo project to experiment with Zendesk API

---

## 🔧 Configuration Parameters

The following properties must be defined to run the application correctly:

| Property Key              | Description                                                                                                                        |
|---------------------------|------------------------------------------------------------------------------------------------------------------------------------|
| `webhook.create-uri`      | The **relative path** to Zendesk's webhook creation API (usually `/api/v2/webhooks`)                                               |
| `zendesk.subdomain`       | The full Zendesk domain URL (e.g. `https://yourcompany.zendesk.com`)                                                               |
| `zendesk.email`           | The email address associated with your Zendesk API account                                                                         |
| `zendesk.api-token`       | The Zendesk API token used for authentication                                                                                      |
| `zendesk.end-point`       | The public URL of your own webhook receiver endpoint, where Zendesk will send webhook events (e.g. https://example.com/status/200) |

---

## 📄 Example `application.properties`
```properties
# Zendesk webhook API (relative path)
webhook.create-uri=/api/v2/webhooks

# Zendesk authentication
zendesk.subdomain=https://yourcompany.zendesk.com
zendesk.email=yourname@yourcompany.com
zendesk.api-token=your_zendesk_api_token
# ⬇️ your own webhook receiver endpoint
zendesk.end-point=https://example.com/status/200
```
