public static String replace(String input, Map<String, String> replacements) {
    if (replacements.isEmpty()) {
        return input;
    }

    return Pattern.compile(String.join("|", (Iterable<String>) replacements.keySet().stream().map(Pattern::quote)::iterator))
        .matcher(input)
        .replaceAll(matchResult -> Matcher.quoteReplacement(replacements.get(matchResult.group())));
}
