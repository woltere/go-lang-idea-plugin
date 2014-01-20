package com.goide;

import com.goide.psi.GoNamedElement;
import com.intellij.lang.documentation.AbstractDocumentationProvider;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.PsiComment;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiWhiteSpace;
import com.intellij.util.Function;
import com.intellij.util.containers.ContainerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class GoDocumentationProvider extends AbstractDocumentationProvider {
  @Override
  public String generateDoc(PsiElement element, PsiElement originalElement) {
    if (element instanceof GoNamedElement) {
      List<PsiComment> comments = getPreviousNonWsComment(element);
      if (!comments.isEmpty()) return getCommentText(comments);
    }
    return null;
  }

  @NotNull
  private static List<PsiComment> getPreviousNonWsComment(@Nullable PsiElement element) {
    if (element == null) return ContainerUtil.emptyList();
    List<PsiComment> result = ContainerUtil.newArrayList();
    PsiElement e;
    for (e = element.getPrevSibling(); e != null; e = e.getPrevSibling()) {
      if (e instanceof PsiWhiteSpace) continue;
      if (e instanceof PsiComment) result.add(0, (PsiComment)e);
      else return result;
    }
    return result;
  }

  private static String getCommentText(List<PsiComment> comments) {
    return StringUtil.join(ContainerUtil.map(comments, new Function<PsiComment, String>() {
      @Override
      public String fun(PsiComment c) {
        return c.getText().replaceFirst("//", "");
      }
    }), "<br/>");
  }
}