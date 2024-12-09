"use client";
import React, { useState } from 'react';
import axios from 'axios';

function Login({user, setUser , setJoin }) {
  const [userId, setUserId] = useState("");
  const [password, setPassword] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('http://localhost:9090/login', {
        userId,
        password,
      });
      if(response.data){
        setUser({
          userId: userId,
          password: password
        });
      }
      else{
        alert("로그인에 실패했습니다. 다시 시도해 주세요.");
      }
      
    } catch (error) {
      console.error("Login failed:", error);
      
    }
  };
  return (
    <div>
      <h1>로그인{user}</h1>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          placeholder="아이디"
          value={userId}
          onChange={(e) => setUserId(e.target.value)}
        />
        <input
          type="password" 
          placeholder="비밀번호"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
        <button type="submit">로그인</button>
      </form>
      <button onClick={setJoin}>회원가입</button>
    </div>
  );
}

export default Login;