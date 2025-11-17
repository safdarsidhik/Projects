from flask import Flask, render_template, request
import numpy as np
import joblib

app = Flask(__name__)

# Load trained model
model = joblib.load("random_forest_model.pkl")

@app.route("/")
def home():
    return render_template("welcome.html")

@app.route("/predictform")
def form_page():
    return render_template("index.html")

@app.route("/welcome")
def welcome():
    return render_template("welcome.html")

@app.route("/predict", methods=["POST"])
def predict():
    try:
        exports_pct = float(request.form["exports_pct"])
        imports_pct = float(request.form["imports_pct"])
        population = float(request.form["population"])
        fdi_pct = float(request.form["fdi_pct"])
        govt_exp_pct = float(request.form["govt_exp_pct"])
        oil_rents_pct = float(request.form["oil_rents_pct"])
        exchange_rate = float(request.form["exchange_rate"])

    except ValueError:
        return "Invalid input. Please enter valid numbers."

    features = np.array([[ 
        exports_pct,
        imports_pct,
        population,
        fdi_pct,
        govt_exp_pct,
        oil_rents_pct,
        exchange_rate
    ]])

    log_prediction = model.predict(features)[0]
    gdp_billion = np.expm1(log_prediction)

    return render_template("result.html", prediction=round(gdp_billion, 3))

if __name__ == "__main__":
    app.run(debug=True)
