package net.serenitybdd.screenplay.questions.targets;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

import java.util.List;

public class TheTarget {
    public static Question<String> valueOf(Target target) {
        return new TargetValue(target);
    }

    public static Question<String> textOf(Target target) {
        return new TargetText(target);
    }

    public static Question<String> selectedValueOf(Target target) {
        return new TargetSelectedValue(target);
    }

    public static Question<String> selectedVisibleTextValueOf(Target target) {
        return new TargetSelectedVisibleText(target);
    }

    public static Question<List<String>> selectedOptionsOf(Target target) {
        return new TargetSelectedOptions(target);
    }

    public static TargetAttributeBuilder attributeNamed(String name) {
        return new TargetAttributeBuilder(name);
    }

    public static TargetCSSBuilder cssValueNamed(String name) {
        return new TargetCSSBuilder(name);
    }

    private static class TargetAttributeBuilder {
        private final String name;

        public TargetAttributeBuilder(String name) {
            this.name = name;
        }

        public Question<String> forTarget(Target target) {
            return new TargetAttribute(target, name);
        }
    }

    private static class TargetCSSBuilder {
        private final String name;

        public TargetCSSBuilder(String name) {
            this.name = name;
        }

        public Question<String> forTarget(Target target) {
            return new TargetCSSValue(target, name);
        }
    }

}