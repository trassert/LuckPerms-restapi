# LuckPerms REST API

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
