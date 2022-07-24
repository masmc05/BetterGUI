package me.hsgamer.bettergui.builder;

import me.hsgamer.bettergui.api.menu.Menu;
import me.hsgamer.bettergui.api.requirement.Requirement;
import me.hsgamer.hscore.builder.MassBuilder;

import java.util.function.Function;

/**
 * The requirement builder
 */
public final class RequirementBuilder extends MassBuilder<RequirementBuilder.Input, Requirement> {
  public static final RequirementBuilder INSTANCE = new RequirementBuilder();

  /**
   * The instance of the requirement builder
   */
  private RequirementBuilder() {
  }

  /**
   * Register a new requirement creator
   *
   * @param creator the creator
   * @param type    the type
   */
  public void register(Function<Input, Requirement> creator, String... type) {
    register(new Element<Input, Requirement>() {
      @Override
      public boolean canBuild(Input input) {
        String requirement = input.name;
        for (String s : type) {
          if (requirement.equalsIgnoreCase(s)) {
            return true;
          }
        }
        return false;
      }

      @Override
      public Requirement build(Input input) {
        return creator.apply(input);
      }
    });
  }

  public static class Input {
    public final Menu menu;
    public final String name;
    public final Object value;

    public Input(Menu menu, String name, Object value) {
      this.menu = menu;
      this.name = name;
      this.value = value;
    }
  }
}
