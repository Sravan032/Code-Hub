import { useEffect, useState } from "react";
import api from "../services/api";
import { Link } from "react-router-dom";

function Problems() {

    const [problems, setProblems] = useState([]);

    useEffect(() => {
        fetchProblems();
    }, []);

    const fetchProblems = async () => {

        try {

            const token = localStorage.getItem("token");
            console.log("Token:", token);

            const response = await api.get(
                "/problems",
                {
                    headers: {
                        Authorization: `Bearer ${token}`
                    }
                }
            );

            console.log("Problems:", response.data);

            setProblems(response.data);

        } catch (error) {

            console.log("Error:", error.response);
            console.log(error);

        }
    };

    return (
        <div>

            <h1>Problems</h1>

            {problems.map(problem => (

                <div key={problem.id}>

                    <h3>
                        <Link to={`/problems/${problem.id}`}>
                            {problem.title}
                        </Link>
                    </h3>

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