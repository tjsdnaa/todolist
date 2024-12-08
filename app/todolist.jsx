import React, { useState, useEffect } from 'react';
import axios from 'axios';
import List from './list'
import Create from './create';

function Todolist({ user }) {
  const [todolist, setTodolist] = useState([]);

  useEffect(() => {
    const fetchTodoList = async () => {
      const response = await axios.get(`http://localhost:9090/todoList?id=${user.userId}`);
      setTodolist(response.data); 

    };

    fetchTodoList(); 
  }, []); 

  return (
    <div>
      {todolist.map(todo => (
        <div key={todo.listId}>
          <List list={todo.listId}/>
        </div>
      ))}
      <Create user={user}/>
    </div>
  );
}

export default Todolist;