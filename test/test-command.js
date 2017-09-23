
const test = require('tape')
const path = require('path')
const childProcess = require('child_process')
const commandPath = process.argv[2]

test('gives recipes and ingredients to the command', t => {
  t.plan(1)

  const command = `${commandPath} --stock ${__dirname}/sample-stock.yaml --recipes ${__dirname}/sample-recipes.yaml`
  const output = childProcess.execSync(command, {encoding: 'utf8'})
  t.deepEqual(output, 'Beef steak\n')
})
