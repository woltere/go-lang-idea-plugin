package main
func f(x int) {}
/**-----
Go file
  PackageDeclaration(main)
    PsiElement(KEYWORD_PACKAGE)('package')
    PsiWhiteSpace(' ')
    PsiElement(IDENTIFIER)('main')
  PsiWhiteSpace('\n')
  FunctionDeclaration(f)
    PsiElement(KEYWORD_FUNC)('func')
    PsiWhiteSpace(' ')
    LiteralIdentifierImpl
      PsiElement(IDENTIFIER)('f')
    PsiElement(()('(')
    FunctionParameterListImpl
      FunctionParameterImpl
        LiteralIdentifierImpl
          PsiElement(IDENTIFIER)('x')
        PsiWhiteSpace(' ')
        TypeNameImpl
          LiteralIdentifierImpl
            PsiElement(IDENTIFIER)('int')
    PsiElement())(')')
    PsiWhiteSpace(' ')
    BlockStmtImpl
      PsiElement({)('{')
      PsiElement(})('}')
