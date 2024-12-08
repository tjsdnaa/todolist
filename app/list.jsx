"use client";
import axios from 'axios';
import { useEffect, useState } from 'react';

function List({ list }) {
    const [data, setData] = useState(null); // 상태 선언

    useEffect(() => {
        const fetchData = async () => {
            const response = await axios.get(`http://localhost:9090/todoList/list/${list}`);
            setData(response.data); // 데이터 저장
        };
        fetchData();
    }, [list]); // id 변경 시 다시 실행

    const handleDelete = async () => {
        await axios.delete(`http://localhost:9090/todoList/list/${list}`);
        setData(null);
    };
    if(data!==null){
        return (
            <div>
                <button onClick={handleDelete}>{data.title}</button>
            </div>
        );
    }
    
}

export default List;