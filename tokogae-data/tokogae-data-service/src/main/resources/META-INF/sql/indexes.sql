create unique index IX_76A4B67A on TOKOGAEData_Phrase (text_[$COLUMN_LENGTH:250$]);

create index IX_D15B871A on TOKOGAEData_PhraseUsage (classNameId, classPK);
create index IX_7436AFED on TOKOGAEData_PhraseUsage (phraseId);