const { Sequelize } = require('sequelize');

const { config } = require('../config/config');

const setupModels = require('./../db/models');

const sequelize = new Sequelize(
config.dbname,
config.dbuser,
config.dbpassword,
{
    host: config.dbhost,
    port: config.dbPort,
    dialect: 'postgres',
}

);

sequelize.sync();
setupModels(sequelize);

module.exports = sequelize;