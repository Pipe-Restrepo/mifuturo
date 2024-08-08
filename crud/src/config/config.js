require('dotenv').config();

const config = {
env:process.env.NODE_ENV || 'dev',
port:process.env.PORT || 3000,
dbuser:process.env.DB_USER,
dbpassword:process.env.DB_PASSWORD,
dbhost:process.env.DB_HOST,
dbname:process.env.DB_NAME,
dbPort:process.env.DB_PORT || 5432,

}

module.exports = { config };