import React, { useState, useEffect } from 'react';
import axios from 'axios';
import List from './list';
import Create from './create';
import Alram from './alram';

function Todolist({ user }) {
  const [todolist, setTodolist] = useState([]);

  useEffect(() => {
    const fetchTodoList = async () => {
      const response = await axios.get(`http://localhost:9090/todoList?id=${user.userId}`);
      setTodolist(response.data); 
    };

    fetchTodoList();
  }, [todolist]);

  
  return (
    <div>
      {todolist.map((todo) => (
        <div key={todo.listId}>
          <List list={todo.listId} />
        </div>
      ))}
      <Create user={user} setTodolist={setTodolist} />
      <Alram todolist={todolist}/>
    </div>
  );
}

export default Todolist;