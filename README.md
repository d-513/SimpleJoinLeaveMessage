# SimpleJoinLeaveMessage

A spigot plugin to send leave and join messages

### Config
Self explanatory
```yaml
messages:
  join: "&a{name} joined the server!"
  leave: "&c{name} left the server ):"
```

### Placeholders

##### Built-in placeholders
{name} - the name of the user that joined/left the server

##### PlaceholderAPI
You can use PlaceholderAPI in the join and leave messages, just like you would anywhere else.
```yaml
messages:
  join: "%player_name% joined the server!"
  leave: "%player_name% left the server ):"
```

Additionally, the plugin provides `%sm_lastJoined%` and `%sm_lastLeft%` placeholders for use in other plugins

### Building

```bash
git clone https://github.com/dada513/SimpleJoinLeaveMessage
mvn clean package
```