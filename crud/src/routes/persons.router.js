const express = require('express');
const router = express.Router();
const personsControllers = require('../controllers/persons.controllers');

router
.get('/' , personsControllers.get)
.get('/:id' , personsControllers.getById)
.post('/' , personsControllers.create)
.put('/:id' , personsControllers.update)
.delete('/:id' , personsControllers._delete);

module.exports = router;