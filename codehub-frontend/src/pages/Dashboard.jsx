import { Link } from "react-router-dom";

function Dashboard() {
    return (
        <div>
            <h1>Welcome to CodeHub :)</h1>
            <Link to="/problems">Problems</Link>
            <br></br>
            <Link to="/submissions">
                My Submissions
            </Link>
        </div>
    );
}

export default Dashboard;