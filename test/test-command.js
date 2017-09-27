
const argv = require('minimist')(process.argv.slice(2))
const commandVersion = argv['cmd-ver'] || '1';
const versionTestDir = `./v${commandVersion}`;

require(versionTestDir);
