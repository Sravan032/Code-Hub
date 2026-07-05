import { useEffect, useState } from "react";
import api from "../services/api";

function MySubmissions() {

    const [submissions, setSubmissions] = useState([]);

    const fetchSubmissions = async () => {

        try {

            const token = localStorage.getItem("token");

            const response = await api.get(
                "/submissions/my",
                {
                    headers: {
                        Authorization: `Bearer ${token}`
                    }
                }
            );

            setSubmissions(response.data);

        } catch (error) {

            console.log(error);

        }
    };

    useEffect(() => {

        fetchSubmissions();

    }, []);

    return (
        <div>

            <h1>My Submissions</h1>

            <table border="1">

                <thead>

                    <tr>

                        <th>Problem</th>
                        <th>Language</th>
                        <th>Status</th>
                        <th>Submitted At</th>

                    </tr>

                </thead>

                <tbody>

                    {submissions.map(submission => (

                        <tr key={submission.id}>

                            <td>{submission.problem.title}</td>

                            <td>{submission.language}</td>

                            <td>{submission.status}</td>

                            <td>
                                {new Date(submission.submittedAt).toLocaleString()}
                            </td>

                        </tr>

                    ))}

                </tbody>

            </table>

        </div>
    );
}

export default MySubmissions;