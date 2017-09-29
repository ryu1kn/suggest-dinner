
const test = require('tape')
const path = require('path')
const childProcess = require('child_process')
const commandPath = process.argv[2]

test('finds a single recipe', t => {
  t.plan(1)

  const command = `${commandPath} --stock ${__dirname}/data/single-match--stock.yaml --recipes ${__dirname}/data/single-match--recipes.yaml`
  const output = childProcess.execSync(command, {encoding: 'utf8'})
  t.deepEqual(output, 'Beef steak\n')
})

test('finds all recipes that needs can be cooked', t => {
  t.plan(1)

  const command = `${commandPath} --stock ${__dirname}/data/multi-match--stock.yaml --recipes ${__dirname}/data/multi-match--recipes.yaml`
  const output = childProcess.execSync(command, {encoding: 'utf8'})
  t.deepEqual(output, 'Pot-au-feu\nBeef steak\n')
})
