import { Link } from "react-router-dom";

function Dashboard() {
    return (
        <div>
            <h1>Welcome to CodeHub :)</h1>
            <Link to="/problems">Problems</Link>
        </div>
    );
}

export default Dashboard;