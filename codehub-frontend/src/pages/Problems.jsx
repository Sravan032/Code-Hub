import { useEffect, useState } from "react";
import api from "../services/api";

function Problems() {

    const [problems, setProblems] = useState([]);

    useEffect(() => {
        fetchProblems();
    }, []);

    const fetchProblems = async () => {

        try {

            const token = localStorage.getItem("token");

            const response = await api.get(
                "/problems",
                {
                    headers: {
                        Authorization: `Bearer ${token}`
                    }
                }
            );

            setProblems(response.data);

        } catch (error) {

            console.log(error);

        }
    };

    return (
        <div>

            <h1>Problems</h1>

            {problems.map(problem => (

                <div key={problem.id}>

                    <h3>{problem.title}</h3>

                    <p>{problem.description}</p>

                    <p>
                        Difficulty: {problem.difficulty}
                    </p>

                    <hr />

                </div>

            ))}

        </div>
    );
}

export default Problems;