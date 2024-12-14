from flask import Flask, request, jsonify

app = Flask(__name__)

@app.route('/analyze', methods=['POST'])
def analyze():
    text = request.json.get('text', '')
    sentiment = "positive" if "good" in text else "neutral"
    return jsonify({"sentiment": sentiment})

if __name__ == '__main__':
    app.run(host='127.0.0.1', port=5000)