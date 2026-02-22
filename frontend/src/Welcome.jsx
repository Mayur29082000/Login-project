import { useNavigate } from "react-router-dom";

const Welcome = () => {
  const navigate = useNavigate();
  const token = localStorage.getItem("token");

  const handleLogout = () => {
    localStorage.removeItem("token");
    navigate("/");
  };

  return (
    <div style={styles.wrapper}>
      <div style={styles.card}>
        <h1 style={styles.title}>🎉 Welcome!</h1>
        <p style={styles.subtitle}>
          You have successfully logged in.
        </p>

        <div style={styles.tokenBox}>
          <strong>Token:</strong>
          <p style={styles.token}>{token}</p>
        </div>

        <button style={styles.button} onClick={handleLogout}>
          Logout
        </button>
      </div>
    </div>
  );
};

const styles = {
  wrapper: {
    height: "100vh",
    display: "flex",
    justifyContent: "center",
    alignItems: "center",
    background: "linear-gradient(135deg, #667eea, #764ba2)",
  },
  card: {
    background: "#fff",
    padding: "40px",
    borderRadius: "15px",
    boxShadow: "0 15px 35px rgba(0,0,0,0.2)",
    textAlign: "center",
    width: "400px",
  },
  title: {
    marginBottom: "10px",
  },
  subtitle: {
    color: "#555",
    marginBottom: "20px",
  },
  tokenBox: {
    background: "#f4f4f4",
    padding: "10px",
    borderRadius: "8px",
    fontSize: "12px",
    marginBottom: "20px",
    wordBreak: "break-all",
  },
  token: {
    color: "#333",
  },
  button: {
    padding: "10px 20px",
    border: "none",
    borderRadius: "8px",
    background: "#667eea",
    color: "#fff",
    cursor: "pointer",
  },
};

export default Welcome;