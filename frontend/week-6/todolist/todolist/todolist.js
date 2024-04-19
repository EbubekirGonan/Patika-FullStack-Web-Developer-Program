
let tasks = [];

let userFormDOM = document.querySelector('#userForm')
userFormDOM.addEventListener('submit', addTask)


function addTask(event){
    event.preventDefault();
    const taskInput = document.querySelector('#taskInput');
    const taskText = taskInput.value.trim();

    if(taskText !== ''){
        tasks.push(taskText);
        renderTask();
        taskInput.value = '';
    }else{
        alert("Boş not oluşturulamaz");
    }
}

function renderTask(){
    const taskListDOM = document.querySelector('#taskList')
    taskListDOM.innerHTML = '';

    tasks.forEach((taskText, index) => {
        const liDOM = document.createElement('li');
        liDOM.innerHTML = taskText;
        liDOM.classList.add('list-group-item')

        const deleteButton = document.createElement('span')
        deleteButton.textContent = '\u274C';
        deleteButton.className ='delete-button'

        deleteButton.addEventListener('click', (event) =>{
            event.stopPropagation();
            removeTask(index);
        });

        liDOM.appendChild(deleteButton);

        liDOM.addEventListener('click', () => {
            toggleTaskCompletion(liDOM, index);
        })

        const firstChild = taskListDOM.firstChild;
        taskListDOM.insertBefore(liDOM, firstChild);
        
    })
}

function toggleTaskCompletion(li, index){
    li.classList.toggle('completed');

    tasks[index].completed = !tasks[index].completed;
}

function removeTask(index){
    tasks.splice(index,1);index
    renderTask();
}

document.addEventListener('DOMContentLoaded', () => {
    renderTask();
    document.querySelector('#taskInput').focus();
});




