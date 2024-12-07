"use client";
import React, { useState, useEffect } from 'react';
import axios from 'axios';

function List({ id }) {
    const [data, setData] = useState(null);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await axios.get(`http://localhost:9090/todoList/list/${id}`);
                setData(response.data);
            } catch (error) {
                console.error("데이터를 불러오는 중 오류 발생:", error);
            }
        };

        fetchData();
    }, [id]);  // id가 변경될 때마다 새로운 데이터를 가져옴

    if (!data) {
        return <div>로딩 중...</div>;
    }

    return (
        <div>
            <input type="button" value={data} />
        </div>
    );
}

export default List;