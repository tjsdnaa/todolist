import axios from 'axios';
import {useState } from 'react';

function Create({user}) {
    const userId=user.userId;
    const [todo, setTodo] = useState({
        title: '',
        content: '',
        closingDate: new Date().toISOString().slice(0, 16),
        userId: userId
    });
    


    const handleCreate = async () =>{
        await axios.post('http://localhost:9090/todoList',todo);
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
            </div>
            <button type="submit">todolist 생성하기</button>
        </form>
    );
}

export default Create;