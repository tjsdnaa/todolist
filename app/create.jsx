import axios from 'axios';
import {useState } from 'react';

function Create({user,setTodolist}) {
    const userId=user.userId;
    const [todo, setTodo] = useState({
        title: '',
        content: '',
        closingDate: '',
        userId: userId
    });
    


    const handleCreate = async (e) =>{
        e.preventDefault();
        
        await axios.post('http://localhost:9090/todoList',todo);
        
        const response = await axios.get(`http://localhost:9090/todoList?id=${user.userId}`);
        setTodolist(response.data);
    }
    
    
    return (
        <form onSubmit={handleCreate}>
            <div>
                <label htmlFor="title">Title:</label>
                <input
                    id="title"
                    type="text"
                    value={todo.title}
                    onChange={(e) => setTodo((prevTodo) => ({ ...prevTodo, title: e.target.value }))}
                    required
                />
                <input
                    id="datetime-local"
                    type="datetime-local"
                    value={todo.closingDate}
                    onChange={(e) => setTodo((prevTodo) => ({ ...prevTodo, closingDate: e.target.value }))}
                    required
                />
            </div>
            <button type="submit">todolist 생성하기</button>
        </form>
    );
}

export default Create;