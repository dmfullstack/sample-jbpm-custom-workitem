{
  "id": "f0f7fd5c-c567-434b-b4d6-526cb6814f06",
  "name": "src.main.resources.CompleteFlow-taskform.frm",
  "model": {
    "processName": "CompleteFlow",
    "processId": "src.main.resources.CompleteFlow",
    "properties": [
      {
        "name": "firstname",
        "typeInfo": {
          "type": "BASE",
          "className": "java.lang.String",
          "multiple": false
        },
        "metaData": {
          "entries": [
            {
              "name": "field-readOnly",
              "value": false
            }
          ]
        }
      },
      {
        "name": "lastname",
        "typeInfo": {
          "type": "BASE",
          "className": "java.lang.String",
          "multiple": false
        },
        "metaData": {
          "entries": [
            {
              "name": "field-readOnly",
              "value": false
            }
          ]
        }
      }
    ],
    "formModelType": "org.kie.workbench.common.forms.jbpm.model.authoring.process.BusinessProcessFormModel"
  },
  "fields": [
    {
      "maxLength": 100,
      "placeHolder": "Firstname",
      "id": "field_1972046530953251E12",
      "name": "firstname",
      "label": "Firstname",
      "required": false,
      "readOnly": false,
      "validateOnChange": true,
      "binding": "firstname",
      "standaloneClassName": "java.lang.String",
      "code": "TextBox",
      "serializedFieldClassName": "org.kie.workbench.common.forms.fields.shared.fieldTypes.basic.textBox.definition.TextBoxFieldDefinition"
    },
    {
      "maxLength": 100,
      "placeHolder": "Lastname",
      "id": "field_308408708381227E11",
      "name": "lastname",
      "label": "Lastname",
      "required": false,
      "readOnly": false,
      "validateOnChange": true,
      "binding": "lastname",
      "standaloneClassName": "java.lang.String",
      "code": "TextBox",
      "serializedFieldClassName": "org.kie.workbench.common.forms.fields.shared.fieldTypes.basic.textBox.definition.TextBoxFieldDefinition"
    }
  ],
  "layoutTemplate": {
    "version": 2,
    "style": "FLUID",
    "layoutProperties": {},
    "rows": [
      {
        "properties": {},
        "layoutColumns": [
          {
            "span": "12",
            "height": "12",
            "properties": {},
            "rows": [],
            "layoutComponents": [
              {
                "dragTypeName": "org.kie.workbench.common.forms.editor.client.editor.rendering.EditorFieldLayoutComponent",
                "properties": {
                  "field_id": "field_1972046530953251E12",
                  "form_id": "f0f7fd5c-c567-434b-b4d6-526cb6814f06"
                }
              }
            ]
          }
        ]
      }
    ]
  }
}