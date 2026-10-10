# LuckPerms REST API

<p align="center">
<a href=https://t.me/lumintoch><img src=https://img.shields.io/badge/Sponsored%20by-Luminto-purple?style=for-the-badge&logo=githubsponsors&logoColor=white></a>
<img src="https://img.shields.io/badge/Paper-blue?style=for-the-badge&logo=spigotmc&logoColor=white&logoSize=auto" alt="Badge">
<img src="https://img.shields.io/badge/Java-orange?style=for-the-badge&logo=openjdk&logoSize=auto" alt="Badge">
</p>

REST API for LuckPerms as a Paper plugin.

## Installation

1. Build with `mvn package`.
2. Copy `target/luckperms-rest-api.jar` to the server `plugins` directory.
3. Make sure LuckPerms is installed.
4. Edit `plugins/LuckPermsRestApi/config.yml` and restart the server.

The API listens on `http://localhost:8080` by default.
The OpenAPI schema is available at `http://localhost:8080/docs/openapi`.

## Configuration

```yaml
http-port: 8080
auth: false
auth-keys: ''
cache-users: true
cache-groups: true
cache-tracks: true
```

When `auth` is enabled, provide comma-separated API keys in `auth-keys` and send them as `Authorization: Bearer <key>`.
