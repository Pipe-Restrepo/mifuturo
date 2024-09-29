//Definir Variables

const formulario = document.querySelector("#formulario");
const tituloForm = document.querySelector("#titulo-formulario");
const task = document.querySelector(".tareas");
const total = document.querySelector("#total");
const completadas = document.querySelector("#completadas");
let tareas = [];

//Definir Eventos

(() => {
    formulario.addEventListener("submit", validarFormulario);
    task.addEventListener("click", eliminarTarea)
    task.addEventListener("click", tareacompletada)

})()


//Definir Funciones
function validarFormulario(e) {
    e.preventDefault();

    //Validar datos del input
    const tarea = document.querySelector("#tarea").value;

    //Valida espacios vacios y envio de datos vacios desde del formulario
    if (!tarea.trim()) {
        console.log('Formulario Vacio');
        return
    }

    //Crear objeto que contiene la info de cada tarea (crear identificador aleatorio, tarea y estado)

    const objTarea = {
        id: Date.now(),
        tarea: tarea,
        estado: false
    }

    tareas = [...tareas, objTarea];
    formulario.reset();

    mostrarHtml();
}

//Para crear cada tarea, automatizarlas y que se agreguen a la lista una a una sin duplicarlas

function mostrarHtml() {

    //Resetea y limita la duplicidad de tareas
    task.innerHTML = '';


    //Condicional para mostrar el bloque de tareas en cero
    if (tareas.length < 1) {
        const mensaje = document.createElement("h5");
        mensaje.textContent = "-Sin Tareas-"
        return
    }

    tareas.forEach((item) => {
        const itemTarea = document.createElement("div");
        itemTarea.classList.add("item-tarea");
        itemTarea.innerHTML = `
        ${item.estado ? (
                `<p class ="completa">${item.tarea}</p> `

            ) : (
                `<p>${item.tarea}</p> `
            )}
        <div class="botones">
        <button data-id="${item.id}" class="eliminar">x</button>
        <button data-id="${item.id}" class="completada">?</button>
    </div>
`

        task.appendChild(itemTarea)

    })

    //Mostrar Contador de tareas totales y completadas
    const totalTareas = tareas.length;
    total.textContent = `Total tareas:${totalTareas}`
    const tareasCompletadas = tareas.filter( item => item.estado === true ).length;
    console.log(tareasCompletadas);
    completadas.textContent = `Completadas:${tareasCompletadas}`

}

//Eliminar Tarea llamando ID tarea y envolviendo en dato tipo número

function eliminarTarea(e) {
    if (e.target.classList.contains("eliminar")) {
        const tareaID = Number(e.target.getAttribute("data-id"));

        //Eliminar Tarea y mostrar en el div cuando se agreguen tareas

        const newTask = tareas.filter((item) => item.id !== tareaID);
        console.log(newTask);
        tareas = newTask;
        mostrarHtml();

    }
}

function tareacompletada(e) {
    if (e.target.classList.contains("completada")) {
        const tareaID = Number(e.target.getAttribute("data-id"));


        //Tarea completada
        const newTask = tareas.map((item) => {
            if (item.id === tareaID) {
                item.estado = !item.estado;
                return item;
            } else {
                return item
            }
        })

        mostrarHtml();
    }
}