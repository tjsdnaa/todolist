"use client";
import React, { useState } from 'react';
import axios from 'axios';
import Todolist from './todolist';

function Login() {

  const [userId, setUserId] = useState('');
  const [password, setPassword] = useState('');
  const [isLoggedIn, setIsLoggedIn] = useState(false); 

 
  const handleSubmit = async (e) => {
    e.preventDefault(); 

    try {
      const response = await axios.post('http://localhost:9090/login', {
        userId,
        password,
      });
      
      if (response.data) { 
        console.log('로그인 성공:', response.data);
        setIsLoggedIn(true); 
      } else {
        alert("로그인에 실패했습니다.");
      }
    } catch (error) {
      console.error('로그인 오류:', error);
    }
  };

  if (isLoggedIn) {
    return <Todolist />;
  } else {
    return (
        <div>
          <h1>로그인</h1>
          <form onSubmit={handleSubmit}>
            <input
              type="text"
              name="userId"
              id="userId"
              value={userId}
              onChange={(e) => setUserId(e.target.value)} 
            />
            <input
              type="password"
              name="password"
              id="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)} 
            />
            <input type="submit" value="로그인" />
          </form>
        </div>
      );
  }
}

export default Login;