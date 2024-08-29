package telran.games.dto;

import org.json.JSONObject;

public record MoveResult(String guess, int bulls, int cows) {
@Override
public String toString() {
	JSONObject jsonObj = new JSONObject();
	jsonObj.put("guess", guess);
	jsonObj.put("bulls", bulls);
	jsonObj.put("cows", cows);
	return jsonObj.toString();
}
public MoveResult(JSONObject jsonObj) {
	this(jsonObj.getString("guess"), jsonObj.getInt("bulls"),
			jsonObj.getInt("cows"));
}
}
